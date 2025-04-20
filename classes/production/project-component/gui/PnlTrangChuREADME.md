Why circularImage is an Array
-
```java
final BufferedImage[] circularImage = {null};
```
This might look a bit odd at first — so here’s the key idea:

Java doesn’t allow modification of non-final variables from inside anonymous inner classes or lambdas unless they are effectively `final`.

But an array’s content can be modified, even if the reference is final. So this is a common workaround in Java when you want a variable to be shared and mutable inside an anonymous inner class (like the custom `JButton` in this case).

```java
BufferedImage circularImage = null; // Not allowed to modify inside inner class
```

```java
final BufferedImage[] circularImage = {null}; // You can modify circularImage[0]
```

Logics:
-

1. Temporary JLabel is used to load the image:
   2. `utils.ImageHelper.loadImage(...)` loads the image into `tempLabel`.
2. If image is present:
   3. Convert it into a circular cropped version using Graphics2D and Ellipse2D.
   4. Store it in circularImage[0].
5. Custom JButton is created:
   6. Overrides paintComponent() to:
      7. Draw a white circle background.
      8. Paint the circular profile picture if available.
      9. Add a dark overlay if hovered.
10. Button styling is modified:
    11. setContentAreaFilled(false) and similar settings make the button look clean, without default UI elements.