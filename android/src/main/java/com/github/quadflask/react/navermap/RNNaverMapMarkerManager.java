package com.github.quadflask.react.navermap;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.naver.maps.map.overlay.Align;

import static com.github.quadflask.react.navermap.ReactUtil.parseAlign;
import static com.github.quadflask.react.navermap.ReactUtil.parseColorString;
import static com.github.quadflask.react.navermap.ReactUtil.toNaverLatLng;

public class RNNaverMapMarkerManager extends EventEmittableViewGroupManager<RNNaverMapMarker> {
    private static final Align DEFAULT_CAPTION_ALIGN = Align.Bottom;

    private final DisplayMetrics metrics;

    public RNNaverMapMarkerManager(ReactApplicationContext reactContext) {
        super(reactContext);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            metrics = new DisplayMetrics();
            ((WindowManager) reactContext.getSystemService(Context.WINDOW_SERVICE))
                    .getDefaultDisplay()
                    .getRealMetrics(metrics);
        } else {
            metrics = reactContext.getResources().getDisplayMetrics();
        }
    }

    @Override
    String[] getEventNames() {
        return new String[]{
                "onClick"
        };
    }

    @NonNull
    @Override
    public String getName() {
        return "RNNaverMapMarker";
    }

    @NonNull
    @Override
    protected RNNaverMapMarker createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RNNaverMapMarker(this, reactContext);
    }

    @ReactProp(name = "coordinate")
    public void setCoordinate(RNNaverMapMarker view, ReadableMap map) {
        view.setCoordinate(toNaverLatLng(map));
    }

    @ReactProp(name = "anchor")
    public void setAnchor(RNNaverMapMarker view, ReadableMap map) {
        // should default to (0.5, 1) (bottom middle)
        float x = map != null && map.hasKey("x") ? (float) map.getDouble("x") : 0.5f;
        float y = map != null && map.hasKey("y") ? (float) map.getDouble("y") : 1.0f;
        view.setAnchor(x, y);
    }

    @ReactProp(name = "image")
    public void setImage(RNNaverMapMarker view, @Nullable String source) {
        view.setImage(source);
    }

    @ReactProp(name = "pinColor", defaultInt = Color.RED, customType = "Color")
    public void setPinColor(RNNaverMapMarker view, int pinColor) {
        view.setIconTintColor(pinColor);
    }

    @ReactProp(name = "rotation", defaultFloat = 0.0f)
    public void setMarkerRotation(RNNaverMapMarker view, float rotation) {
        view.setRotation(rotation);
    }

    @ReactProp(name = "flat", defaultBoolean = false)
    public void setFlat(RNNaverMapMarker view, boolean flat) {
        view.setFlat(flat);
    }

    @ReactProp(name = "width", defaultFloat = 64)
    public void setWidth(RNNaverMapMarker view, float width) {
        int widthInScreenPx = Math.round(metrics.density * width);
        view.setWidth(widthInScreenPx);
    }

    @ReactProp(name = "height", defaultFloat = 64)
    public void setHeight(RNNaverMapMarker view, float height) {
        int heightInScreenPx = Math.round(metrics.density * height);
        view.setHeight(heightInScreenPx);
    }

    @ReactProp(name = "animated", defaultBoolean = false)
    public void setAnimated(RNNaverMapMarker view, boolean animated) {
        view.setAnimated(animated);
    }

    @ReactProp(name = "easing", defaultInt = -1)
    public void setEasing(RNNaverMapMarker view, int easingFunction) {
        view.setEasing(easingFunction);
    }

    @ReactProp(name = "duration", defaultInt = 500)
    public void setDuration(RNNaverMapMarker view, int duration) {
        view.setDuration(duration);
    }

    @ReactProp(name = "alpha", defaultFloat = 1f)
    public void setAlpha(RNNaverMapMarker view, float alpha) {
        view.setAlpha(alpha);
    }

    @ReactProp(name = "caption")
    public void setCaption(RNNaverMapMarker view, ReadableMap map) {
        if (map == null || !map.hasKey("text")) {
            view.removeCaption();
            return;
        }
        String text = map.getString("text");
        int textSize = map.hasKey("textSize") ? map.getInt("textSize") : 16;
        int color = map.hasKey("color") ? parseColorString(map.getString("color")) : Color.BLACK;
        int haloColor = map.hasKey("haloColor") ? parseColorString(map.getString("haloColor")) : Color.WHITE;
        Align align = map.hasKey("align") ? parseAlign(map.getInt("align")) : DEFAULT_CAPTION_ALIGN;

        view.setCaption(text, textSize, color, haloColor, align);
    }

    @ReactProp(name="id")
    public void setId(RNNaverMapMarker view, String id){
        view.getVo().setId(id);
    }

    @ReactProp(name="companyId")
    public void setCompanyId(RNNaverMapMarker view, int companyId){
        view.getVo().setCompanyId((long)companyId);
    }

    @ReactProp(name="name")
    public void setName(RNNaverMapMarker view, String name){
        view.getVo().setName(name);
    }

    @ReactProp(name="address")
    public void setAddress(RNNaverMapMarker view, String address){
        view.getVo().setAddress(address);
    }

    @ReactProp(name="bookingTimeCount")
    public void setBookingTimeCount(RNNaverMapMarker view, Integer bookingTimeCount){
        view.getVo().setBookingTimeCount(bookingTimeCount);
    }

    @ReactProp(name="coast")
    public void setCoast(RNNaverMapMarker view, int cost){
        view.getVo().setCoast((long)cost);
    }

    @ReactProp(name="lanes")
    public void setLanes(RNNaverMapMarker view, int lanes){
        view.getVo().setLanes(lanes);
    }

    @ReactProp(name="favorites")
    public void setFavorites(RNNaverMapMarker view, String favorites){
        view.getVo().setFavorites(favorites);
    }

    @ReactProp(name="distance")
    public void setDistance(RNNaverMapMarker view, String distance){
        view.getVo().setDistance(distance);
    }

    @ReactProp(name="franchisee")
    public void setFranchisee(RNNaverMapMarker view, String franchisee){
        view.getVo().setFranchisee(franchisee);
    }

    @ReactProp(name="parking")
    public void setParking(RNNaverMapMarker view, int parking){
        view.getVo().setParking(parking);
    }


}
