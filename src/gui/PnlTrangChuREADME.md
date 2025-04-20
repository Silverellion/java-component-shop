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

his implementation creates a circular profile picture button using Java Swing. The button displays a user's image in a clean, styled manner with hover effects.

## 1. Temporary JLabel is used to load the image

### 2. `utils.ImageHelper.loadImage(...)` loads the image into `tempLabel`

An image is initially loaded into a temporary `JLabel` using a utility method for image handling.

## 3. If image is present

### 4. Convert it into a circular cropped version using Graphics2D and Ellipse2D

If an image is successfully loaded, it is processed using `Graphics2D` and `Ellipse2D` to create a circular cropped version.

### 5. Store it in `circularImage[0]`

The circular image is stored in an array for later use in painting.

## 6. Custom JButton is created

### 7. Overrides `paintComponent()` to:

#### 8. Draw a white circle background

The button draws a white circular background to maintain a clean appearance.

#### 9. Paint the circular profile picture if available

If a circular profile picture is present, it is painted inside the button.

#### 10. Add a dark overlay if hovered

A semi-transparent dark overlay is added when the mouse hovers over the button for visual feedback.

## 11. Button styling is modified

The following settings are applied to clean up the button’s appearance:

- `setContentAreaFilled(false)`
- `setBorderPainted(false)`
- `setFocusPainted(false)`

These ensure that no default UI elements interfere with the custom design.
