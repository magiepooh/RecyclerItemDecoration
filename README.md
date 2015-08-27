# RecyclerItemDecoration

RecyclerItemDecoration allows you to draw divider between items in recyclerview with multiple ViewType without considering items' positions!

When using recyclerView with different ViewType, you either have only one simple divider or different types of dividers. When you want to draw different dividers between recyclerView's items, basically you must consider items' position; often you need to have separate ItemDecoration's behaviors declared in your code using switch cases or if statements. For example, each time items' position changes happen, you must rewrite ItemDecoration's behaviors.

You don't need to think about items' position! You need to care about their **ViewType**!!

# Image
![demo_vertical] ![demo_horizontal]

# Support
- LineaLayoutManager
  - Vertical
  - Horizontal
  - Horizontal(Reverse)

# Gradle
```
compile 'com.github.magiepooh:recycler-itemdecoration:1.0.0@aar'
```

# How To Use
```java
RecyclerView.ItemDecoration decoration = new VerticalItemDecoration.Builder(this)
                .first(R.drawable.shape_decoration_sea_blue_h_8)
                .type(VerticalAdapter.ViewType.TYPE_A.ordinal(), R.drawable.shape_decoration_black_h_1)
                .type(VerticalAdapter.ViewType.TYPE_B.ordinal(), R.drawable.shape_decoration_gray_h_1)
                .last(R.drawable.shape_decoration_flush_orange_h_8)
                .build();

recyclerView.addItemDecoration(decoration);
```

# License
```
Copyright (C) 2015 magiepooh
Copyright (C) 2013 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[demo_vertical]:https://raw.githubusercontent.com/magiepooh/RecyclerItemDecoration/master/art/demo_vertical.gif
[demo_horizontal]:https://raw.githubusercontent.com/magiepooh/RecyclerItemDecoration/master/art/demo_horizontal.gif
