public class Main {
    public static void main(String[] args) {

        Figure circle = new Circle(6);
        
        Visitor figureDrawer = new DrawFigure();
        Visitor areaGetter = new AreaGet();
        Visitor showName = new ShowFigureName();

        circle.accept(figureDrawer);
        circle.accept(showName);
        circle.accept(areaGetter);

    }

    interface Visitor {
        void visit(Circle figure);
        void visit(EquilateralTriangle figure);
        void visit(Square figure);
    }

    interface Figure {
        void accept(Visitor visitor);
    }

    static class Square implements Figure {
        private int height;
        private int width;

        public Square(int height , int width){
            this.height = height;
            this.width = width;
        }
        public int getArea(){
            return (this.height * this.width);
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class EquilateralTriangle implements Figure {
        private int height;
        private int side;

        public EquilateralTriangle(int height , int side){
            this.height = height;
            this.side = side;
        }
        public int getArea(){
            return ((this.height*this.side)/2);
        }
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class Circle implements Figure {
        private int radius;

        public Circle(int radius){
            this.radius = radius;
        }
        public double getArea(){
            return (3.14 * radius*radius);
        }
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class DrawFigure implements Visitor {


        @Override
        public void visit(Circle figure) {
            System.out.println("Нарисована фигура с радиусом " + figure.radius);
        }

        @Override
        public void visit(EquilateralTriangle figure) {
            System.out.println("Нарисована фигура с высотой " + figure.height + " и основанием " + figure.side);
        }

        @Override
        public void visit(Square figure) {
            System.out.println("Нарисована фигура со сторонами " + figure.height + " и " + figure.width);
        }
    }
    static class ShowFigureName implements Visitor {


        @Override
        public void visit(Circle figure) {
            System.out.println("Данная фигура называется круг");
        }

        @Override
        public void visit(EquilateralTriangle figure) {
            System.out.println("Данная фигура называется треугольник");
        }

        @Override
        public void visit(Square figure) {
            System.out.println("Данная фигура называется прямоугольник");
        }
    }

    static class AreaGet implements Visitor {


        @Override
        public void visit(Circle figure) {
            System.out.println("Площадь данной фигуры равна " + figure.getArea());
        }

        @Override
        public void visit(EquilateralTriangle figure) {
            System.out.println("Площадь данной фигуры равна " + figure.getArea());
        }

        @Override
        public void visit(Square figure) {
            System.out.println("Площадь данной фигуры равна " + figure.getArea());
        }
    }
}