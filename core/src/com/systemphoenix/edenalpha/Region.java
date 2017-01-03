package com.systemphoenix.edenalpha;

import com.systemphoenix.edenalpha.Codex.RegionCodex;

public class Region {
    private String name, code, mapFile;
    private float x, y, forestLandPercentage, worldWidth, worldHeight;
    private int mapIndex;

    public Region(int codexIndex) {
        this.code                   = RegionCodex.codes[codexIndex];
        this.name                   = RegionCodex.names[codexIndex];
        this.forestLandPercentage   = RegionCodex.forestPercentage[codexIndex];
        this.x                      = RegionCodex.camX[codexIndex];
        this.y                      = RegionCodex.camY[codexIndex];
        this.mapIndex               = RegionCodex.mapIndeces[codexIndex];
        this.worldWidth             = RegionCodex.worldSize[codexIndex].x;
        this.worldHeight            = RegionCodex.worldSize[codexIndex].y;
        this.mapFile                = RegionCodex.mapFiles[codexIndex];
    }

    public String getCode() {
        return code;
    }

    public String getName(){
        return name;
    }

    public String getMapFile() {
        return mapFile;
    }

    public float getLifePercentage() {
        return forestLandPercentage;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWorldWidth() {
        return worldWidth;
    }

    public float getWorldHeight() {
        return worldHeight;
    }

    public int getMapIndex() {
        return mapIndex;
    }
}
