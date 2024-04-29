package lain.mods.neutralizer;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.monster.Enemy;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

@Mod("mobneutralizer")
public class MobNeutralizer {

    public MobNeutralizer(IEventBus bus) {
        bus.addListener(this::setup);
    }

    private void onLivingVisibilityCheck(LivingEvent.LivingVisibilityEvent event) {
        if (event.getLookingEntity() instanceof Enemy)
            if (event.getEntity() instanceof ServerPlayer)
                if (!(event.getEntity() instanceof FakePlayer))
                    event.modifyVisibility(0.0D);
    }

    private void setup(FMLCommonSetupEvent event) {
        NeoForge.EVENT_BUS.addListener(this::onLivingVisibilityCheck);
    }

}
