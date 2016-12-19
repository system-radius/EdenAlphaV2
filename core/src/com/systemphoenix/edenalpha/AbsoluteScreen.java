package com.systemphoenix.edenalpha;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class AbsoluteScreen implements Screen, GestureDetector.GestureListener {
    protected final float screenWidth = Gdx.graphics.getWidth(), screenHeight = Gdx.graphics.getHeight();
    protected float worldWidth = screenWidth, worldHeight = screenHeight;

    protected EdenAlpha game;

    protected SpriteBatch gameGraphics;
    protected BitmapFont font;
    protected OrthographicCamera cam;

    public AbsoluteScreen(EdenAlpha game) {
        this.game = game;
        this.gameGraphics = game.getGameGraphics();
        this.font = game.getFont();
        this.cam = new OrthographicCamera(worldWidth, worldHeight);
    }

    public void boundCamera() {
        cam.zoom = MathUtils.clamp(cam.zoom, 0.1f, worldWidth/screenWidth);

        float effectiveViewportWidth = cam.viewportWidth * cam.zoom;
        float effectiveViewportHeight = cam.viewportHeight * cam.zoom;

        cam.position.x = MathUtils.clamp(cam.position.x, effectiveViewportWidth / 2f, worldWidth - effectiveViewportWidth / 2f);
        cam.position.y = MathUtils.clamp(cam.position.y, effectiveViewportHeight / 2f, worldHeight  - effectiveViewportHeight / 2f);
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        float limit = 5;
        if(Math.abs(deltaX) < limit) {
            deltaX = 0;
        }

        if(Math.abs(deltaY) < limit) {
            deltaY = 0;
        }

        cam.position.x -= deltaX;
        cam.position.y += deltaY;
        Gdx.app.log("Verbose", "(" + cam.position.x + ", " + cam.position.y + ")");
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }

    @Override
    public void show() {
        GestureDetector gd = new GestureDetector(this);
        Gdx.input.setInputProcessor(gd);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.95f, 0.95f, 0.95f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}