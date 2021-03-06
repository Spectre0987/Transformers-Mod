package com.marctron.transformersmod.items.gun;

public interface IShootable {


    int clipSize = 0;

    /**
     * True if is a bullet clip
     * False if individual bullets that can be loaded directly
     */
    boolean isClip();

    /**
     * If a clip, then returns how many bullets can be stored in it
     * If not, then returns the max stack size
     */
    int getMaxAmmo();

    Object getRegistryName();
}