package com.jesz.createdieselgenerators;

import com.jesz.createdieselgenerators.compat.EveryCompatCompat;
import com.jesz.createdieselgenerators.compat.computercraft.CCProxy;
import com.jesz.createdieselgenerators.items.FluidStorageItem;
import com.jesz.createdieselgenerators.other.FuelTypeManager;
import com.jesz.createdieselgenerators.content.molds.MoldType;
import com.jesz.createdieselgenerators.packets.CDGPackets;
import com.simibubi.create.compat.Mods;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.createmod.ponder.foundation.PonderIndex;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import io.github.fabricators_of_create.porting_lib.event.common.ExplosionEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.TagKey;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jesz.createdieselgenerators.CreateDieselGenerators.ID;

public class CreateDieselGenerators implements ModInitializer {
    public static final String ID = "createdieselgenerators";
    public static final String NAME = "Create: Diesel Generators";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);


    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }

    @Override
    public void onInitialize() {
        TagRegistry.FluidTags.init();
        CDGSounds.prepare();
        CDGItems.register();
        CDGBlocks.register();
        CDGFluids.register();
        CDGBlockEntityTypes.register();
        CDGEntityTypes.register();
        CDGSounds.register();
        CDGRecipes.register();
        CDGMenuTypes.register();
        MoldType.register();
        CDGMountedStorageTypes.register();
        CDGCreativeTab.registerItemGroups();

        REGISTRATE.register();

        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(FuelTypeManager.ReloadListener.INSTANCE);

        ExplosionEvents.DETONATE.register(Events::onExplosion);
        CommandRegistrationCallback.EVENT.register(Events::onCommandRegister);

        FluidStorage.ITEM.registerFallback((itemStack, context) -> {
            if (itemStack.getItem() instanceof FluidStorageItem storageItem)
                return storageItem.getFluidStorage(itemStack, context);
            return null;
        });

        if(FabricLoader.getInstance().isModLoaded("moonlight")) {
            EveryCompatCompat.init();
        }

        Mods.COMPUTERCRAFT.executeIfInstalled(() -> CCProxy::register);

        //ForgeConfigRegistry.INSTANCE.register()
        //ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConfigRegistry.SERVER_SPEC, "createdieselgenerators-server.toml");
        //ConfigRegistry.register();
        ForgeConfigRegistry.INSTANCE.register(ID, ModConfig.Type.SERVER, CDGConfig.SERVER_SPEC);
        //ModLoadingContext.registerConfig(ID,  ModConfig.Type.SERVER, ConfigRegistry.SERVER_SPEC);
        CDGPackets.registerPackets();
    }

    /*public static int getOilAmount(ServerLevel serverLevel, Holder<Biome> biome, int x, int z, long seed){
        Random random = new Random(new Random(seed).nextLong() + (long) x * z);
        int amount = Math.abs(random.nextInt());
        var reg = serverLevel.registryAccess().registry(Registries.BIOME);
        if (reg.isPresent()) {

            TagKey<Biome> key = AllTags.optionalTag(reg.get(), CreateDieselGenerators.asResource("oil_biomes"));

            boolean isHighInOil = biome == null || biome.is(key);
            if(biome != null && biome.is(AllTags.optionalTag(reg.get(), CreateDieselGenerators.asResource("deny_oil_biomes")))) {
                return 0;
            }

            if(isHighInOil ? (random.nextFloat(0, 100) >= CDGConfig.HIGH_OIL_PERCENTAGE.get()) : (amount % 100 >= CDGConfig.OIL_PERCENTAGE.get())) {
                return 0;
            }
            if(CDGConfig.OIL_DEPOSITS_INFINITE.get()) {
                return Integer.MAX_VALUE;
            }

            if(isHighInOil) {
                return (int) (Mth.clamp(amount % 400000, 8000, 400000)*CDGConfig.HIGH_OIL_MULTIPLIER.get());
            }
            return (int) (Mth.clamp(amount % 15000, 0, 12000)*CDGConfig.OIL_MULTIPLIER.get());
        }
        return 0;
    }*/

    public static Component Lang(String path, Object... args) {
        return Component.translatable(ID+"."+path, args);
    }

}
