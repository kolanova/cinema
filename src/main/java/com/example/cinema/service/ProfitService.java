package com.example.cinema.service;

import com.example.cinema.model.Food;
import com.example.cinema.model.Sale;
import com.example.cinema.model.Ticket;
import com.example.cinema.repository.SalesRepository;
import com.example.cinema.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

// where I put the logic and call the repository
@Service

public class ProfitService {
    private final SalesRepository salesRepository;
    private final TicketRepository ticketsRepository;

    public ProfitService(SalesRepository salesRepository, TicketRepository ticketsRepository) {
        this.salesRepository = salesRepository;
        this.ticketsRepository = ticketsRepository;
    }

    // here adding a ticket profit to the food profit
    public BigDecimal calculateTotalProfit(int roomId) {
        return calulateTicketProfit(roomId).add(calculateFoodProfit(roomId));
    }

    // I will add calculate Ticket Profit by time to use enum from TicketTime and it will take a roomId (find by roomId)
    // and ticket time
    //than query in the repository

    // calculating a ticket profit
    public BigDecimal calulateTicketProfit(int roomId) {
        List<Sale> sales = salesRepository.findByRoomId(roomId);
        // 1. first I create  salesRepository.findByRoomId(roomId);
        // 2. than implementing a List method from the repository of Sales
        // 3. (List<Sale> findByRoomId(int roomId)
        // 4. after this I can use the SALES in my service
        List<Ticket> tickets = sales.stream().map((sale) ->
                sale.getTicket()).collect(Collectors.toList());
        // here for each sale we want to return what is a profit
        List<BigDecimal> profits = tickets.stream().map((ticket) ->
                ticket.getPrice().subtract(ticket.getCost()) ).collect(Collectors.toList());
        // check Lambdas method one more time
        //stream means that I need to enter it in sells and for each sell I will map it (to transform it)
        // so for each sale
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal tp:profits) {
            sum = sum.add(tp);
        }
        return sum;
    }

    // calculating  food profit
    private BigDecimal calculateFoodProfit(int roomId) {
        List<Sale> sales = salesRepository.findByRoomId(roomId);
        List<Food> foods = sales.stream().map((sale) ->
                sale.getFood()).collect(Collectors.toList());
        List<BigDecimal> profits = foods.stream().map((food) ->
                        food.getPrice().subtract(food.getCost()) ).collect(Collectors.toList());
        //stream means that I need to enter it in sells and for each sell I will map it (to transform it)
        // so for each sale
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal fp:profits) {
            sum = sum.add(fp);
        }
        return sum;
    }
}
