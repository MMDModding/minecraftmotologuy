package cyano.mineralogy;

import cyano.mineralogy.patching.PatchHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// This seems really not nice design, it'll do til we refactor the whole thing..
@Mod.EventBusSubscriber(modid = Mineralogy.MODID)
public class MineralogyEventBusSubscriber {
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		Mineralogy.MineralogyBlockRegistry.values().forEach(block -> event.getRegistry().register(block.PairedBlock));
		
	    event.getRegistry().registerAll(PatchHandler.MineralogyPatchRegistry.values().toArray(new Block[PatchHandler.MineralogyPatchRegistry.size()]));	    
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
	    event.getRegistry().registerAll(Mineralogy.MineralogyItemRegistry.values().toArray(new Item[Mineralogy.MineralogyItemRegistry.size()]));
	}
	
	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		event.getRegistry().registerAll(Mineralogy.MineralogyRecipeRegistry.values().toArray(new IRecipe[Mineralogy.MineralogyRecipeRegistry.size()]));
	}
}
