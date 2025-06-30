package br.ufma.ecp.jlox;

public class Interpreter implements Expr.Visitor<Object> {
    public Object interpret(Expr expression) {
        try {
            Object value = evaluate(expression);
            System.out.println(stringify(value));
            return value;
        } catch (RuntimeError error) {
            Lox.runtimeError(error);
            return null;
        }
    }

    private Object evaluate(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public Object visitLiteralExpr(Expr.Literal expr) {
        return expr.value;
    }

    @Override
    public Object visitGroupingExpr(Expr.Grouping expr) {
        return evaluate(expr.expression);
    }
}
