float r1 = 100;
float r2 = 100;

float m1 = 10;
float m2 = 15;

float a1 = PI/4;
float a2 = PI/8;

float a1_v = 0;
float a2_v = 0;
float a1_a = 0.01;
float a2_a = -0.02;

float g = 1;

float px2 = 0;
float py2 = 0;


PGraphics canvas;

void setup(){
size(680, 650);
canvas = createGraphics(980, 950);
canvas.beginDraw();
canvas.background(0);
canvas.endDraw();

}

void draw(){
  
  float num1 = -g * (2 * m1 + m2) * sin(a1);
  float num2 = -m2 * g * sin(a1 - 2 * a2);
  float num3 = -2 * sin(a1 - a2) * m2 * (a2_v * a2_v * r2 + a2_v * a2_v * r1 * cos(a1 - a2));
  float den = r1 * (2 * m1 + m2 - m2 * cos(2 * a1 - 2 * a2));
  
  double a1_a = (num1 + num2 + num3) / den;
  
  float Num1 = 2 * sin(a1 - a2) * (a1_v * a1_v * r1 * (m1 + m2) + g * (m1 + m2) * cos(a1) + a2_v * a2_v * r2 * m2 * cos(a1 - a2));
  float Den = r2 * ( 2 * m1 + m2 -  m2 * cos(2 * a1 - 2 * a2));
    
  double a2_a = Num1 / Den;
  
image(canvas, 0, 0);
stroke(255);
strokeWeight(2);

translate(350, 300);

float x1 = r1 * sin(a1);
float y1 = r1 * cos(a1);

line(0, 0, x1, y1);
fill(255);
ellipse(x1, y1, m1, m1);

float x2 = x1 + r2 * sin(a2);
float y2 = y1 + r2 * cos(a2);

line(x1, y1, x2, y2);
fill(255);
ellipse(x2, y2, m2, m2);


a1_v += a1_a;
a2_v += a2_a; 
a1 += a1_v;
a2 += a2_v;



canvas.beginDraw();
canvas.translate(350, 300);
canvas.strokeWeight(1);


 

if(frameCount < 500){
canvas.stroke(#6bf5d9);
}else if(frameCount > 500 && frameCount < 1000){
canvas.stroke(#33c6a9);
}else if(frameCount > 1000 && frameCount < 1500){
canvas.stroke(#177e69);
}else if(frameCount > 1500 && frameCount < 2000){
canvas.stroke(#088f84);
}else if(frameCount > 2000 && frameCount < 2500){
canvas.stroke(#4eafa4);
}

if(frameCount > 1){
canvas.line(px2, py2, x2, y2);
}


canvas.endDraw();

px2 = x2;
py2 = y2;

textSize(20);
text("Generative Art | Prince-gh", 110, 330);
} 