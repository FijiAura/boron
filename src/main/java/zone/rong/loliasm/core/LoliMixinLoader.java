package zone.rong.loliasm.core;

import me.towdium.jecharacters.JechConfig;
import net.minecraftforge.fml.common.Loader;
import org.spongepowered.asm.mixin.Mixins;
import zone.rong.loliasm.config.LoliConfig;
import zone.rong.mixinbooter.MixinLoader;

@MixinLoader
public class LoliMixinLoader {

    {
        if (LoliConfig.instance.squashBakedQuads) {
            Mixins.addConfiguration("mixins.bakedquadsquasher.json");
        }
        if (Loader.isModLoaded("immersiveengineering") && LoliConfig.instance.fixBlockIEBaseArrayIndexOutOfBoundsException) {
            Mixins.addConfiguration("mixins.modfixes_immersiveengineering.json");
        }
        if (Loader.isModLoaded("astralsorcery") && LoliConfig.instance.optimizeAmuletRelatedFunctions) {
            Mixins.addConfiguration("mixins.modfixes_astralsorcery.json");
        }
        if (Loader.isModLoaded("astralsorcery") && LoliConfig.instance.fixAmuletHolderCapability) {
           Mixins.addConfiguration("mixins.capability_astralsorcery.json");
        }
        if (Loader.isModLoaded("jei") && LoliConfig.instance.optimizeAndCacheJEISearchTrees && !Loader.isModLoaded("jecharacters") || !JechConfig.enableJEI) {
            Mixins.addConfiguration("mixins.modfixes_jei.json");
        }
        if (Loader.isModLoaded("evilcraftcompat") && LoliConfig.instance.repairEvilCraftEIOCompat) {
            Mixins.addConfiguration("mixins.modfixes_evilcraftcompat.json");
        }
    }

}
