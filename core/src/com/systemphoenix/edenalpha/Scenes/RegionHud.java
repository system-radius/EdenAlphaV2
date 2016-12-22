package com.systemphoenix.edenalpha.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.systemphoenix.edenalpha.EdenAlpha;

public class RegionHud extends AbsoluteHud {

    private Label regionCode, regionName, regionForestPercentage;
    private int padding = 20;

    public RegionHud(EdenAlpha game) {
        super(game);

        initialize();
    }

    public RegionHud(EdenAlpha game, float projectedWidth, float projectedHeight) {
        super(game);

        this.viewport.update((int)projectedWidth, (int)projectedHeight);

//        this.viewport.setScreenWidth((int)projectedWidth);
//        this.viewport.setScreenHeight((int)projectedHeight);

        initialize();
    }

    private void initialize() {
        Color border = Color.BLACK;
//        Color fontColor = new Color(0.5f, 1f, 0.5f, 1f);
        Color fontColor = Color.WHITE;
        BitmapFont tempFont = font;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/neuropol.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 32;
        parameter.borderColor = border;
        parameter.borderWidth = 3;
        font = generator.generateFont(parameter);
        generator.dispose();

        Table temp = new Table();
        temp.top();
        temp.setFillParent(true);

        regionCode = new Label("Region Code", new Label.LabelStyle(font, fontColor));
        regionName = new Label("Region Name", new Label.LabelStyle(font, fontColor));
        regionForestPercentage = new Label("Region Forest Percentage", new Label.LabelStyle(font, fontColor));

        temp.add(regionCode).padTop(padding).padLeft(padding);
        temp.row();
        temp.add(regionName).padLeft(padding);
        temp.row();
        temp.add(regionForestPercentage).padLeft(padding);

        stage.addActor(temp);
//        stage.

        font = tempFont;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode.setText(regionCode);
    }

    public void setRegionName(String regionName) {
        this.regionName.setText(regionName);
    }

    public void setRegionForestPercentage(String regionForestPercentage) {
        this.regionForestPercentage.setText(regionForestPercentage);
    }
}
