package com.fluffyhamsters.client;

import com.fluffyhamsters.FluffyHamsters;
import com.fluffyhamsters.HamsterEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class HamsterRenderer extends MobRenderer<HamsterEntity,HamsterModel> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(new ResourceLocation(FluffyHamsters.MODID,"hamster"),"main");
    private static final ResourceLocation TEXTURE = new ResourceLocation(FluffyHamsters.MODID,"textures/entity/hamster.png");
    public HamsterRenderer(EntityRendererProvider.Context ctx) { super(ctx,new HamsterModel(ctx.bakeLayer(LAYER)),0.25f); }
    @Override public ResourceLocation getTextureLocation(HamsterEntity entity) { return TEXTURE; }
}
