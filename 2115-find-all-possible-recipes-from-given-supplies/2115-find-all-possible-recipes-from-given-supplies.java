class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> answer = new ArrayList<>();
        Set<String> newIngredients = new HashSet<>();
        Set<Integer> canNotMake = new HashSet<>();
        boolean hasNewIngredients = false;
        for(int i = 0; i < recipes.length; i++) 
            canNotMake.add(i);
        for(int i= 0; i < supplies.length; i++) 
            newIngredients.add(supplies[i]);
        do {
            hasNewIngredients = false;
            Set<Integer> toRemove = new HashSet<>();
            for(Integer recipeNum : canNotMake) {
                List<String> needIngredients = ingredients.get(recipeNum);
                boolean canMake = true;
                for(String ingredient : needIngredients) {
                    if(!newIngredients.contains(ingredient)) {
                        canMake = false;
                        break;
                    }
                }
                if(canMake) {
                    newIngredients.add(recipes[recipeNum]);
                    answer.add(recipes[recipeNum]);
                    toRemove.add(recipeNum);
                    hasNewIngredients = true;
                }
            }
            for(Integer remove : toRemove)
                canNotMake.remove(remove);
        } while(hasNewIngredients);
        return answer;
    }
}