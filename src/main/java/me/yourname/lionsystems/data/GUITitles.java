package me.yourname.lionsystems.data;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public class GUITitles {
    public static Component invWatchGUITitle;
    public static Component OperatorMenuGUI;
    public static Component defaultMenuGUI;
    public static Component settingsMenuGUI;
    public static Component RecipeGeneratorGUI;

    public static void setTitles(){
        invWatchGUITitle = Component.text("Inventory", TextColor.color(255, 0, 255));
        OperatorMenuGUI = Component.text("LS MENU OP", TextColor.color(255, 0, 255));
        defaultMenuGUI = Component.text("LS MENU", TextColor.color(0, 255, 255));
        settingsMenuGUI = Component.text("LS Settings", TextColor.color(150, 0, 255));
        RecipeGeneratorGUI = Component.text("LS RECIPE GENERATOR", TextColor.color(0, 255, 255));
    }
}
