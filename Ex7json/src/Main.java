import interfaces.MyAnotation;
import model.Car;
import model.Rodas;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static String generate(Object o) throws InvocationTargetException, IllegalAccessException {
        StringBuffer stringBuffer = new StringBuffer();
        // Iterator<StringBuffer> it = stringBuffer.iterator();
        stringBuffer.append("{");
        stringBuffer.append("\n");
        String aspas = "\"";

        for (Method m : o.getClass().getDeclaredMethods())
            if ((m.getName().startsWith("get") || m.getName().startsWith("is")) &&
                    m.getParameterTypes().length == 0 &&
                    Modifier.isPublic(m.getModifiers()) &&
                    m.getAnnotation(MyAnotation.class) != null) {
                if (m.getName().startsWith("is")) {
                    String nome = null;
                    nome = m.getName().substring(2,3).toLowerCase()+ m.getName().substring(4);

                } else {
                    Object value = m.invoke(o);
                    String name = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4);

                    if (value instanceof Number || value instanceof List<?> || value instanceof Rodas)
                        aspas = "";

                    else aspas = "\"";


                    List<String> novaList = new ArrayList<>();
                    if (value instanceof List<?>) {
                        for (Object item : ((List<?>) value).toArray()) {
                            String valueString = item.toString();
                            if (!(item instanceof Number)) {
                                item = ('"' + valueString + '"');
                                novaList.add(item.toString());
                            } else {
                                break;
                            }
                            value = novaList;
                        }
                    } else if (value instanceof Rodas) {

                        value = generate(value);

                    }
                    else if(value instanceof Date){
                    SimpleDateFormat data  =   new SimpleDateFormat("dd/MM/yyyy");
                        value = data.format(value);
                    }

                    stringBuffer.append('"').append(name).append('"').append("  : ").append(aspas).append(value)
                            .append(aspas).append(",").append("\n");

                }
                }
                stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());

                stringBuffer.append("\n}");
                return stringBuffer.toString();

    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Car car = new Car();
        List<Integer> strings = new ArrayList<>();
        strings.add(1);
        strings.add(14);
        Rodas rodas = new Rodas(23, 4, "marca", strings);
        Date data = new Date(103, 3, 12);
        System.out.println(data);

        car.setAno(2012);
        car.setNome("Celta");
        car.setMarca("GM");
        car.setModelo("plus");
        car.setData(data);
        car.setListaJson(List.of("joao", "joao2", "joao3"));
        car.setLintNumber(List.of(1, 2, 3, 4));
        car.setRodas(rodas);
        //car.setData(LocalDateTime.parse(dtf.format(now)))
        System.out.println(generate(car));
    }
}