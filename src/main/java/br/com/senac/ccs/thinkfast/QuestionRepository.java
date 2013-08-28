package br.com.senac.ccs.thinkfast;

import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository {

    private List<Question> questions;
    private Question currentQuestion;
    private Iterator<Question> questionsPool;

    public Question getCurrentQuestion() {
        return currentQuestion;
    }
    
    public Question next() {
        this.currentQuestion = questionsPool.next();
        return this.currentQuestion;
    }

    @PostConstruct
    public void init() {
        this.questions = new ArrayList<Question>();
        this.questions.add( new Question( "Qual a capital do Brasil?", Arrays.asList( new String[]{ "Brasilia", "São Paulo", "Rio de Janeiro" } ), "Brasilia" ) );
        this.questions.add( new Question( "Qual a capital dos EUA?", Arrays.asList( new String[]{ "Washington DC", "California", "Nevada" } ), "Washington DC" ) );
        this.questions.add( new Question( "Qual a capital da Russia?", Arrays.asList( new String[]{ "Berlin", "Paris", "Moscou" } ), "Moscou" ) );
        this.questionsPool = Iterators.cycle( new ArrayList( questions ) );
        this.currentQuestion = questionsPool.next();
    }
}
