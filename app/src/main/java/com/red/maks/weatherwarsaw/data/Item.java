package com.red.maks.weatherwarsaw.data;

import org.json.JSONObject;

/**
 * Created by Maks on 3/8/2016.
 */
public class Item implements JSONPopulator
{
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
    condition = new Condition();
        condition.populate(data.optJSONObject("condition"));
    }
}
