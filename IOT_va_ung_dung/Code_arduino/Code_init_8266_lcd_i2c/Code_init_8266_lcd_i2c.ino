#include <LiquidCrystal_I2C.h>

#include "Wire.h"
LiquidCrystal_I2C lcd(0x27, 20, 2);
char buff[50];
volatile byte indx;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  lcd.init();
  lcd.backlight();
  lcd.clear();
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()>0) {
    byte c = Serial.read();
    if(indx < sizeof buff) {
      buff[indx++] = c;
      if(c =='\r') {
        lcd.print(buff);
        delay(10000);
        indx = 0;
        lcd.clear();
      }
    }
  }
}
