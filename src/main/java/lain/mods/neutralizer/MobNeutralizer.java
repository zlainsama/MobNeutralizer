package lain.mods.neutralizer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mobneutralizer")
public class MobNeutralizer
{

    public MobNeutralizer()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void onPlayerVisibilityCheck(PlayerEvent.Visibility event)
    {
        event.modifyVisibility(0D);
    }

    private void setup(FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerVisibilityCheck);
    }

}
