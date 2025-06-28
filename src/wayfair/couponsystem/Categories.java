package wayfair.couponsystem;

/*
*   List<String[]> categories = List.of(
    new String[]{"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
    new String[]{"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
    new String[]{"CategoryName:Bed & Bath", "CategoryParentName:None"},
    new String[]{"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
    new String[]{"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
    new String[]{"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
    new String[]{"CategoryName:Baby And Kids", "CategoryParentName:None"}
);*/
public class Categories {
    String categoryName;
    String CategoryParentName;

    public Categories(String categoryName,String categoryParentName) {
        this.categoryName = categoryName;
        this.CategoryParentName=categoryParentName;
    }

    public String getCategoryParentName() {
        return CategoryParentName;
    }

    public void setCategoryParentName(String categoryParentName) {
        CategoryParentName = categoryParentName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
