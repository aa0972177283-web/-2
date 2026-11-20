package com.fluffyhamsters.client;

import com.fluffyhamsters.FluffyHamsters;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.renderer.entity.EntityRenderers;

@Mod.EventBusSubscriber(modid=FluffyHamsters.MODID,bus=Mod.EventBusSubscriber.Bus.MOD,value=Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent public static void layers(EntityRenderersEvent.RegisterLayerDefinitions event) { event.registerLayerDefinition(HamsterRenderer.LAYER,HamsterModel::createBodyLayer); }
    @SubscribeEvent public static void renderers(EntityRenderersEvent.RegisterRenderers event) { event.registerEntityRenderer(FluffyHamsters.HAMSTER.get(),HamsterRenderer::new); }
}
