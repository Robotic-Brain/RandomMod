package de.roboticbrain.randommod.core.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import de.roboticbrain.randommod.lib.Reference;

/**
 * Random Mod
 * 
 * Modified version of EE3 LogHelper Class
 * 
 * @author Robotic-Brain
 */

/**
 * Equivalent-Exchange-3
 * 
 * LogHelper
 * 
 * @author pahimar
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class LogHelper {

    private static Logger marmorLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        marmorLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        marmorLogger.log(logLevel, message);
    }
    
    /**
     * @author Robotic-Brain
     * @return Logger instance for direct invoking of methods
     */
    public static Logger logger() {
        return marmorLogger;
    }

}
