package com.systemphoenix.edenalpha.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.systemphoenix.edenalpha.EdenAlpha;
import com.systemphoenix.edenalpha.FieldSelection;
import com.systemphoenix.edenalpha.Region;
import com.systemphoenix.edenalpha.Scenes.RegionHud;

public class MapScreen extends AbsoluteScreen {
    private float sizeWidth = 480f;
//    private float sizeHeight = sizeWidth * screenHeight / screenWidth;
    private float sizeHeight = 384f;
    private boolean flingDisabled = false;

    private Sprite mapSprite;
    private FieldSelection fieldSelection;

    private RegionHud regionHud;
    private Region currentRegion;

    private GameScreen gameScreen = null;
    private Viewport viewport;

    public MapScreen(EdenAlpha game) {
        super(game);
        this.regionHud = new RegionHud(game, sizeWidth, sizeHeight);
        this.game.getMainScreen().setLoadingMessage("Creating field...");
        this.fieldSelection = new FieldSelection(game.getSelectedMapIndex());

        this.game.getMainScreen().setLoadingMessage("Setting up camera...");
        worldHeight = worldWidth = 1403;
        try {
            mapSprite = new Sprite(new Texture(Gdx.files.internal("maps/[PH]map.gif")));
            Gdx.app.log("Verbose", "Successfully loaded first map");
        } catch(Exception e) {
            Gdx.app.log("Verbose", "mapsprite " + e.getMessage());
        }
        mapSprite.setPosition(0, 0);
        mapSprite.setSize(worldWidth, worldHeight);
        cam.setToOrtho(false, sizeWidth, sizeHeight);

        this.viewport = new StretchViewport(sizeWidth, sizeHeight, cam);

        fieldSelection.setCameraPosition(cam);
        cam.update();

        this.game.getMainScreen().setLoadingMessage("Creating input...");

        this.game.getMainScreen().setLoadingMessage("Tap to start!");
        this.game.getMainScreen().setCanStart(true);
        this.game.setScreen(game.getMainScreen());
    }

    @Override
    public void render(float delta) {
//        update stuff below
        boundCamera();
        fieldSelection.setCameraPosition(cam);
        cam.update();
        gameGraphics.setProjectionMatrix(cam.combined);
//        update stuff above

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameGraphics.begin();
//        render stuff below
        fieldSelection.render(gameGraphics);
//        render stuff above
        gameGraphics.end();

        this.currentRegion = fieldSelection.getRegion();
        if(fieldSelection.getIndex() - 1 >= 0) {
            regionHud.setLeftRegionCode(fieldSelection.getRegionByIndex(fieldSelection.getIndex() - 1).getCode());
        } else {
            regionHud.setLeftRegionCode("            ");
        }
        if(fieldSelection.getIndex() + 1 < fieldSelection.getRegions().length) {
            regionHud.setRightRegionCode(fieldSelection.getRegionByIndex(fieldSelection.getIndex() + 1).getCode());
        } else {
            regionHud.setRightRegionCode("            ");
        }
        regionHud.setRegionCode(currentRegion.getCode());
        regionHud.setRegionName(currentRegion.getName());
        regionHud.setRegionForestPercentage("" + currentRegion.getLifePercentage());
        gameGraphics.setProjectionMatrix(regionHud.getStage().getCamera().combined);
        regionHud.getStage().draw();
    }

//    Gesture listener methods
    @Override
    public boolean tap(float x, float y, int count, int button) {
//        if(flingDisabled) flingDisabled = false;
//        else flingDisabled = true;
        Vector3 touchPos = new Vector3();
        touchPos.set(x, y, 0);
        cam.unproject(touchPos);

        game.setSelectedMapIndex(fieldSelection.getIndex());
        game.setScreen(game.getLoadingScreen());
        game.getLoadingScreen().createGameScreen(game, fieldSelection.getRegionByIndex(game.getSelectedMapIndex()));
        return true;
    }

    @Override
    public boolean fling(float deltaX, float deltaY, int button) {
        float limit = 5;
        if(Math.abs(deltaX) < limit) {
            deltaX = 0;
        }
        int update = 0;
        if(deltaX > 0) {
            update = -1;
        } else if(deltaX < 0) {
            update = 1;
        }
        if(!flingDisabled) fieldSelection.setIndex(update);
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        if(flingDisabled) super.pan(x, y, deltaX, deltaY);
        return true;
    }

//   Screen Methods
    @Override
    public void dispose() {
        mapSprite.getTexture().dispose();
        fieldSelection.dispose();
        if(gameScreen != null) gameScreen.dispose();
        regionHud.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}