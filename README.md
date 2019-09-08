# Simulated Evolution

**Artificial Life Simulation of Bacteria Motion depending on DNA**

## Abstract

Green food appears in a world with red moving cells. These cells eat the food if it is on their position.
Movement of the cells depends on random and their DNA. A fit cell moves around and eats enough to reproduce.
Reproduction is done by splitting the cell and randomly changing the DNA of the two new Cells.
If a cell doesn't eat enough, it will first stand still and after a while it dies.

## Blog Article 
* [http://thomas-woehlke.blogspot.de/2016/01/simulated-evolution-artificial-life-and.html](http://thomas-woehlke.blogspot.de/2016/01/simulated-evolution-artificial-life-and.html)

## Screenshots

### Early Screen 

![Early Screen](etc/img/screen1.png)

### Later Screen 

![Later Screen](etc/img/screen2.png)

### Explanation

<style>
.tablelines table, .tablelines td, .tablelines th {
    border: 1px solid black;
}
</style>

| Color | Explanation |
|-------|-------------|
| ![](etc/img/black.png) | water           |
| ![](etc/img/green.png) | food            |
| ![](etc/img/blue.png) | cell is young   |
| ![](etc/img/yellow.png)  | cell is fat enough to reproduce*   |
| ![](etc/img/red.png)  | cell is old enough to reproduce*   |
| ![](etc/img/light_gray.png)  | cell is hungry and waiting for food or death   |
| ![](etc/img/dark_gray.png)  | cell is old and waiting for death   |
| &nbsp; | * (if cell is fat and old enough for reproduction it splits and changes the childrens DNA)   |
{: .tablelines}

## UML Class Model

![UML Class Model](etc/img/Class_Model.jpg)

## Git Repository
* [https://github.com/thomaswoehlke/simulated-evolution](https://github.com/thomaswoehlke/simulated-evolution)

## Run the Desktop Application
```
git clone https://github.com/thomaswoehlke/simulated-evolution.git
cd simulated-evolution
./gradlw run
```

## Run the Applet Test
```
git clone https://github.com/thomaswoehlke/simulated-evolution.git
cd simulated-evolution
TODO: xxx
```


