package lain.mods.neutralizer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "mobneutralizer", useMetadata = true, acceptedMinecraftVersions = "[1.12, 1.13)", acceptableRemoteVersions = "*", certificateFingerprint = "aaaf83332a11df02406e9f266b1b65c1306f0f76")
public class MobNeutralizer
{

    @Mod.Instance("mobneutralizer")
    public static MobNeutralizer instance;

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onPlayerVisibilityCheck(PlayerEvent.Visibility event)
    {
        event.modifyVisibility(0D);
    }

    public static void setDisabled()
    {
        MinecraftForge.EVENT_BUS.unregister(instance);
    }

    public static void setEnabled()
    {
        MinecraftForge.EVENT_BUS.register(instance);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        setEnabled();
    }

}
