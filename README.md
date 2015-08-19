# RecyclerItemDecoration
ItemDecoration for RecyclerView using LinearLayoutManager

# Image
![screen_shot_01] ![screen_shot_02] ![screen_shot_03]

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

[screen_shot_01]:https://raw.githubusercontent.com/magiepooh/RecyclerItemDecoration/master/art/screen_shot_01.png
[screen_shot_02]:https://raw.githubusercontent.com/magiepooh/RecyclerItemDecoration/master/art/screen_shot_02.png
[screen_shot_03]:https://raw.githubusercontent.com/magiepooh/RecyclerItemDecoration/master/art/screen_shot_03.png
