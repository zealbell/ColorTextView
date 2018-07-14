[![Project Status: Active - Initial development has started, usable release; work hasn't been stopped ](http://www.repostatus.org/badges/0.1.0/active.svg)](http://www.repostatus.org/#active)

ColorTextView
=============
A MultiColor-TextView for having texts of different colors in the same TextView + a highlightable capability

> *public-methods*
```java
        public void setText(String textStatement, String colorStatement)
        public void Highlight(String highlightString, int highlightColor)
        public void unHighlight()
        public void resetColors(String colorStatement)
```

## Quick Start

> Gradle
```xml
   dependencies {
      implementation 'com.github.54LiNKeR:ColorTextView:1.0.0'
   }
```
> Layout

![Demo](shots/color-edit.png)

```xml
  <linkersoft.blackpanther.text.ColorTextView
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:textSize="14sp"
         app:Sentence="Text 1 # Bold Text2% # Text3"
         app:Colours="#F53457:#A31730:#00a0b4"
      />

```
