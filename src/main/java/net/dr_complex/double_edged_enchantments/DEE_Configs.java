package net.dr_complex.double_edged_enchantments;

import eu.midnightdust.lib.config.MidnightConfig;

public class DEE_Configs extends MidnightConfig {

    public static final String TEXT = "text";

    @Comment(category = TEXT, centered = true)
    public static Comment text1;

    @Entry(category = TEXT)
    public static ModeEnum modes = ModeEnum.original;

    public enum ModeEnum{
        original, half, tt
    }
}
