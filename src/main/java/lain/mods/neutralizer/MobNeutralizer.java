package lain.mods.neutralizer;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;

@Mod("mobneutralizer")
public class MobNeutralizer {

    public MobNeutralizer() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (v, n) -> true));

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void onLivingVisibilityCheck(LivingEvent.LivingVisibilityEvent event) {
        if (event.getLookingEntity() instanceof Enemy)
            if (event.getEntityLiving() instanceof ServerPlayer)
                if (!(event.getEntityLiving() instanceof FakePlayer))
                    event.modifyVisibility(0.0D);
    }

    private void setup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(this::onLivingVisibilityCheck);
    }

}
