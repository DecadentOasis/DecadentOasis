import java.util.*;

// Edit these
int NUM_TREES = 24;
int WINDOW_WIDTH = 1200; // This must be a multiple of pulseMaxRadius (below)
int[][] pinks = { 
   {191, 35, 168},
   {127, 24, 112},
   {255, 47, 224},
   {64, 12, 56},
   {229, 42, 202}
};

int[][] purples = {
   {247, 65, 255},
   {178, 60, 232},
   {151, 78, 255},
   {84, 60, 232},
   {65, 89, 255}
};

int[][] nyan_cat = {
   {255, 2, 0},
   {255, 154, 0},
   {255, 255, 0},
   {0, 255, 0},
   {0, 149, 255},
   {102, 32, 255}
};

int[][] palette = purples;

// Don't edit below here
int[] pulseCenterXs = new int[NUM_TREES];
int[] pulseCenterYs = new int[NUM_TREES];

int pulseMaxRadius = 50;
int ringThickness = 30;
int pulseFrequencyBpm = 180; 
int frameRate = 50;

int pulseFrequencyMs = 60 * 1000 / pulseFrequencyBpm; 
int pulseDurationFrames = ((int) ((pulseFrequencyMs / 1000.0) * frameRate));
int incRadiusPerFrame = (pulseMaxRadius / pulseDurationFrames);

int currentRadius = 0;
int[] pulseColors;

// Fisher-Yates shuffle
void shuffleArray(int[] array) {
   Random rng = new Random();
   // i is the number of items remaining to be shuffled.
   for (int i = array.length; i > 1; i--) {
      // Pick a random element to swap with the i-th element.
      int j = rng.nextInt(i);  // 0 <= j <= i-1 (0-based array)
      // Swap array elements.
      int tmp = array[j];
      array[j] = array[i-1];
      array[i-1] = tmp;
   }
}

void drawRing(int ringNum, int ringRadius) {
   int centerX = pulseCenterXs[ringNum];
   int centerY = pulseCenterYs[ringNum];
   int peakColorNum = pulseColors[ringNum];
   int[] peakColor = palette[peakColorNum];

   int ringStart = ringRadius - (ringThickness/2);
   if(ringStart < 0)
      ringStart = 0;
   int ringEnd = ringRadius + (ringThickness/2);
   if(ringEnd > pulseMaxRadius)
      ringEnd = pulseMaxRadius;

   noFill();
   for(int r=ringStart;r<=ringEnd;r++) {
      double sine = sin((r - ringStart) * (PI / ringThickness));
      color c = color((int) (peakColor[0] * sine),
                      (int) (peakColor[1] * sine),
                      (int) (peakColor[2] * sine));
      stroke(c);
      ellipse(centerX, centerY, r*2, r*2);
   }   
}

void randomizePulseColors() {
   shuffleArray(pulseColors);
}

void placeTrees() {
   int treeBlockSz = 4 * pulseMaxRadius;
   int rows = NUM_TREES * treeBlockSz / WINDOW_WIDTH;
   int cols = WINDOW_WIDTH / treeBlockSz;
   for(int i=0, row=0, col=0;i<NUM_TREES;i++) {
      int x = (treeBlockSz / 2) + (treeBlockSz * col);
      int y = (treeBlockSz / 2) + (treeBlockSz * row);
      pulseCenterXs[i] = x;
      pulseCenterYs[i] = y;
      println("Tree center: "+x+","+y);
      col++;
      if(col >= cols) {
         col = 0;
         row++;
      }
   }
   size(WINDOW_WIDTH, rows * treeBlockSz);   
}

void setup() {
   placeTrees();
   frameRate(frameRate);
   pulseColors = new int[NUM_TREES];
   for(int i=0;i<NUM_TREES;i++) {
      pulseColors[i] = i % palette.length;
   }
   randomizePulseColors();
}

void draw() {
   background(0);
   
   for(int i=0;i<pulseCenterXs.length;i++) {
      drawRing(i, currentRadius);
   }
   
   currentRadius += incRadiusPerFrame;
   if(currentRadius > (pulseMaxRadius + ringThickness/2)) {
      currentRadius = 0;
      randomizePulseColors();
   }
}

