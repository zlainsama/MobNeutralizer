package lain.mods.neutralizer;

import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mobneutralizer")
public class MobNeutralizer {

    public MobNeutralizer() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void onLivingVisibilityCheck(LivingEvent.LivingVisibilityEvent event) {
        if (event.getLookingEntity() instanceof IMob)
            if (event.getEntityLiving() instanceof ServerPlayerEntity)
                if (!(event.getEntityLiving() instanceof FakePlayer))
                    event.modifyVisibility(0.0D);
    }

    private void setup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(this::onLivingVisibilityCheck);
    }

}
