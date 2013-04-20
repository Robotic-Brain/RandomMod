package de.roboticbrain.randommod.configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import de.roboticbrain.randommod.lib.BlockIds;
import de.roboticbrain.randommod.lib.Reference;
import de.roboticbrain.randommod.lib.Strings;
//import de.roboticbrain.randommod.lib.ItemIds;

/**
 * Equivalent-Exchange-3
 * 
 * ConfigurationHandler
 * 
 * @author pahimar
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ConfigurationHandler {

    public static Configuration configuration;

    /*public static final String CATEGORY_KEYBIND = "keybindings";
    public static final String CATEGORY_GRAPHICS = "graphics";
    public static final String CATEGORY_AUDIO = "audio";
    public static final String CATEGORY_TRANSMUTATION = "transmutation";
    public static final String CATEGORY_BLOCK_PROPERTIES = Configuration.CATEGORY_BLOCK + Configuration.CATEGORY_SPLITTER + "properties";
    public static final String CATEGORY_RED_WATER_PROPERTIES = CATEGORY_BLOCK_PROPERTIES + Configuration.CATEGORY_SPLITTER + "red_water";
    public static final String CATEGORY_DURABILITY = Configuration.CATEGORY_ITEM + Configuration.CATEGORY_SPLITTER + "durability";*/

    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* Block configs */
            BlockIds.PLAYER_ACCESS_BLOCK = configuration.getBlock(Strings.PLAYER_ACCESS_BLOCK_NAME, BlockIds.PLAYER_ACCESS_BLOCK_DEFAULT).getInt(BlockIds.PLAYER_ACCESS_BLOCK_DEFAULT);

            /* Item configs */
            /*ItemIds.MINIUM_SHARD = configuration.getItem(Strings.MINIUM_SHARD_NAME, ItemIds.MINIUM_SHARD_DEFAULT).getInt(ItemIds.MINIUM_SHARD_DEFAULT);
            ItemIds.INERT_STONE = configuration.getItem(Strings.INERT_STONE_NAME, ItemIds.INERT_STONE_DEFAULT).getInt(ItemIds.INERT_STONE_DEFAULT);
            ItemIds.MINIUM_STONE = configuration.getItem(Strings.MINIUM_STONE_NAME, ItemIds.MINIUM_STONE_DEFAULT).getInt(ItemIds.MINIUM_STONE_DEFAULT);
            ItemIds.PHILOSOPHERS_STONE = configuration.getItem(Strings.PHILOSOPHERS_STONE_NAME, ItemIds.PHILOSOPHERS_STONE_DEFAULT).getInt(ItemIds.PHILOSOPHERS_STONE_DEFAULT);
            ItemIds.ALCHEMICAL_DUST = configuration.getItem(Strings.ALCHEMICAL_DUST_NAME, ItemIds.ALCHEMICAL_DUST_DEFAULT).getInt(ItemIds.ALCHEMICAL_DUST_DEFAULT);
            ItemIds.ALCHEMICAL_BAG = configuration.getItem(Strings.ALCHEMICAL_BAG_NAME, ItemIds.ALCHEMICAL_BAG_DEFAULT).getInt(ItemIds.ALCHEMICAL_BAG_DEFAULT);*/
        }
        catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        }
        finally {
            configuration.save();
        }
    }

    public static void set(String categoryName, String propertyName, String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }
}
