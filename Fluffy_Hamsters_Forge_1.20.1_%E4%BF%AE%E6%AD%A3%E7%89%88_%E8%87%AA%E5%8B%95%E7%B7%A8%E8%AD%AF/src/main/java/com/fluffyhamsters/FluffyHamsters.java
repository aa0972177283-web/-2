package com.fluffyhamsters;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(FluffyHamsters.MODID)
public class FluffyHamsters {
    public static final String MODID = "fluffyhamsters";
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<EntityType<HamsterEntity>> HAMSTER = ENTITIES.register("hamster", () -> EntityType.Builder.of(HamsterEntity::new, MobCategory.CREATURE).sized(0.65f, 0.52f).clientTrackingRange(8).build(MODID + ":hamster"));
    public static final RegistryObject<Item> HAMSTER_EGG = ITEMS.register("hamster_spawn_egg", () -> new SpawnEggItem(HAMSTER, 0xE6B98A, 0xF6EADB, new Item.Properties()));
    public FluffyHamsters() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITIES.register(bus); ITEMS.register(bus);
        bus.addListener(this::attributes); bus.addListener(this::creativeTab);
    }
    private void attributes(EntityAttributeCreationEvent event) { event.put(HAMSTER.get(), HamsterEntity.createAttributes().build()); }
    private void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) event.accept(HAMSTER_EGG);
    }
}
