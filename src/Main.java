public class Main {
    public static void main(String[] args) {

        Figure circle = new Circle(6);
        Figure square = new Square(7 , 8);
        Figure equilateralTriangle = new EquilateralTriangle(5 , 6);

        Visitor squareDrawer = new SquareDrawer();
        Visitor circleDrawer = new CircleDrawer();
        Visitor equilateralTriangleDrawer = new EquilateralTriangleDrawer();

        circle.accept(circleDrawer);//it's working
        circle.accept(squareDrawer);//doesnt workings

    }

    interface Visitor {
        void Draw(Square square);
        void ShowFigureName(Square square);
        void GetArea(Square square);

        void Draw(EquilateralTriangle triangle);
        void ShowFigureName(EquilateralTriangle triangle);
        void GetArea(EquilateralTriangle triangle);

        void Draw(Circle circle);
        void ShowFigureName(Circle circle);
        void GetArea(Circle circle);
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
            visitor.Draw(this);
            visitor.ShowFigureName(this);
            visitor.GetArea(this);
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
            visitor.Draw(this);
            visitor.ShowFigureName(this);
            visitor.GetArea(this);
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
            visitor.Draw(this);
            visitor.ShowFigureName(this);
            visitor.GetArea(this);
        }
    }

    static class SquareDrawer implements Visitor {

        @Override
        public void Draw(Square square) {
            System.out.println("Нарисована фигура со сторонами " + square.width + " " + square.height);
        }
        @Override
        public void ShowFigureName(Square square) {
            System.out.println("Нарисован квадрат");
        }
        @Override
        public void GetArea(Square square) {

            System.out.println("Площадь квадрата = " + square.getArea());
        }
        @Override
        public void GetArea(EquilateralTriangle triangle) { }
        @Override
        public void Draw(EquilateralTriangle triangle) { }
        @Override
        public void ShowFigureName(EquilateralTriangle triangle) { }
        @Override
        public void GetArea(Circle circle) { }
        @Override
        public void Draw(Circle circle) { }
        @Override
        public void ShowFigureName(Circle circle) { }
    }

    static class EquilateralTriangleDrawer implements Visitor {

        @Override
        public void GetArea(Square square) { }
        @Override
        public void Draw(Square square) { }
        @Override
        public void ShowFigureName(Square square) { }
        @Override
        public void Draw(EquilateralTriangle triangle) {
            System.out.println("Нарисована фигура с высотой " + triangle.height + " и основанием " + triangle.height);
        }
        @Override
        public void ShowFigureName(EquilateralTriangle triangle) {
            System.out.println("Нарисован треугольник");
        }
        @Override
        public void GetArea(EquilateralTriangle triangle) {
            System.out.println("Площадь треугольника равна = " + triangle.getArea());
        }
        @Override
        public void GetArea(Circle circle) { }
        @Override
        public void Draw(Circle circle) { }
        @Override
        public void ShowFigureName(Circle circle) { }
    }

    static class CircleDrawer implements Visitor {

        @Override
        public void GetArea(Square square) { }
        @Override
        public void Draw(Square square) { }
        @Override
        public void ShowFigureName(Square square) { }
        @Override
        public void GetArea(EquilateralTriangle triangle) { }
        @Override
        public void Draw(EquilateralTriangle triangle) { }
        @Override
        public void ShowFigureName(EquilateralTriangle triangle) { }
        @Override
        public void Draw(Circle circle) {
            System.out.println("Пользователь фигуру с радиусом " + circle.radius);
        }
        @Override
        public void ShowFigureName(Circle circle) {
            System.out.println("Данная фигура называется круг");
        }
        @Override
        public void GetArea(Circle circle) {
            System.out.println("Площадь круга = " + circle.getArea());
        }
    }
}