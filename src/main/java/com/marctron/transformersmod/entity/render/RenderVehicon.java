package com.marctron.transformersmod.entity.render;

import com.marctron.transformersmod.entity.EntitySwindle;
import com.marctron.transformersmod.entity.EntityVehicon;
import com.marctron.transformersmod.entity.model.ModelSwindle;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVehicon extends RenderLiving<EntityVehicon> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/swindel.png");

    public RenderVehicon(RenderManager manager) {
        super(manager, new ModelSwindle(), 0.25F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityVehicon entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityVehicon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {

        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
