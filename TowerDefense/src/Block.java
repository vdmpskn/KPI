

import java.awt.*;

public class Block extends Rectangle {
    public Rectangle towerSquare;
    public int towerSquareSize = 130;
    public int groundID;
    public int airID;
    public int loseTime = 100, loseFrame = 0;


    public int shotMob = -1;
    public boolean shoting = false;


    public Block(int x, int y, int width, int height, int groundID, int airID){

        setBounds(x,y,width,height);
        towerSquare = new Rectangle(x - (towerSquareSize/2), y - (towerSquareSize/2), width + (towerSquareSize), height + (towerSquareSize));
        this.groundID = groundID;
        this.airID = airID;

    }

    public void draw(Graphics graphics) {

        graphics.drawImage(Screen.tileset_ground[groundID], x, y, width, height, null);

        if (airID != Value.airAir) {

            graphics.drawImage(Screen.tileset_air[airID], x, y, width, height, null);


        }
    }

    public void phyisc() {


        if (shotMob != -1 && towerSquare.intersects(Screen.mobs[shotMob])) {
            shoting = true;
        } else {
            shoting = false;
        }

        if (!shoting) {
            if (airID == Value.airTowerLaser) {
                for (int i = 0; i < Screen.mobs.length; i++) {
                    if (Screen.mobs[i].inGame) {
                        if (towerSquare.intersects(Screen.mobs[i])) {
                            shoting = true;
                            shotMob = i;
                        }
                    }
                }

            }
        }

        if (shoting){

            if (loseFrame>=loseTime){
                Screen.mobs[shotMob].loseHealth(1);
                loseFrame = 0;

            }else{

                loseFrame +=1;

            }


            if(Screen.mobs[shotMob].isDead()){



                shoting = false;
                shotMob = -1;

                Screen.killed += 1;

                Screen.hasWon();

            }


        }


    }

    public void getMoney(int mobID){
                Screen.coinage += Value.deathReward[mobID];
    }

    public void fight(Graphics graphics){
        if(Screen.isDebug) {
            if (airID == Value.airTowerLaser) {
                graphics.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);
            }
        }
            if(shoting){
                graphics.setColor(new Color(255,255,0));
                graphics.drawLine(x +(width/2), y + (height/2), Screen.mobs[shotMob].x + (Screen.mobs[shotMob].width/2), Screen.mobs[shotMob].y + (Screen.mobs[shotMob].height/2));
            }

    }
}
