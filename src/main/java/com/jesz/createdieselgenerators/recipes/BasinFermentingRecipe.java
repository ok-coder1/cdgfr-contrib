package com.jesz.createdieselgenerators.recipes;

import com.jesz.createdieselgenerators.CDGRecipes;
import com.simibubi.create.content.processing.basin.BasinRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeParams;

public class BasinFermentingRecipe extends BasinRecipe {
    public BasinFermentingRecipe(ProcessingRecipeParams params) {
        super(CDGRecipes.BASIN_FERMENTING, params);
    }
}
