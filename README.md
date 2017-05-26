# KCompatSample
====================
KCompatSample is an Android library for features which are not available in AppCompact support library

## Features
 * KCompactProgressBar - supports progressTint color for older versions of android


##Installation

Latest version of the library can be found on Maven Central.

### For Gradle users

Open your `build.gradle` Then, include the library as dependency:
```gradle
compile 'compile 'com.ksk.marujolla.kcompat:kcompat:0.13''
```

### For Maven users

Add this dependency to your `pom.xml`:
```xml
<dependency>
  <groupId>com.ksk.marujolla.kcompat</groupId>
  <artifactId>kcompat</artifactId>
  <version>0.13</version>
  <type>pom</type>
</dependency>
```
 
##Usage

*Please see the `/KCompactSample-app` app for a more detailed code example of how to use the library.*

1. Add the `SignaturePad` view to the layout you want to show.
```xml
<marujolla.ksk.kcompat.KCompatProgressBar
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="100dp"
        android:layout_height="100dp"
        app:kProgressTint="@android:color/holo_blue_dark"/>
```

2. Configure attributes.
 * `kProgressTint` - The color of the progress bar.
 
3. Set Progress Tint
 * `public void setIndeterminateTintList(ColorStateList tint)`

## License

    Copyright 2017 Koteswara shiva kartik Marujolla

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
