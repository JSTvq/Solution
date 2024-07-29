package com.kir138.lesson4.task1;

import com.kir138.lesson4.task1.model.Role;
import com.kir138.lesson4.task1.model.Team;
import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.repository.PgTeamRepository;
import com.kir138.lesson4.task1.repository.PgUserRepository;
import com.kir138.lesson4.task1.repository.TeamRepository;
import com.kir138.lesson4.task1.repository.UserRepository;
import com.kir138.lesson4.task1.service.CrudService;
import com.kir138.lesson4.task1.service.PgTeamService;
import com.kir138.lesson4.task1.service.PgUserService;
import com.kir138.lesson4.task1.service.TeamService;
import com.kir138.lesson4.task1.service.UserService;
import com.kir138.lesson4.task1.sqlConnect.DatabaseUtil;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String database = scanner.next();
        CrudService<User, Long> userService = null;
        CrudService<Team, Long> teamService = null;
        DatabaseUtil databaseUtil = new DatabaseUtil();


        if (database.equals("excel")) {
            UserRepository userRepository = new UserRepository();
            userService = new UserService(userRepository);

            TeamRepository teamRepository = new TeamRepository();
            teamService = new TeamService(teamRepository);

        } else if (database.equals("db")) {
            PgUserRepository pgUserRepository = new PgUserRepository();
            userService = new PgUserService(pgUserRepository);

            PgTeamRepository pgTeamRepository = new PgTeamRepository();
            teamService = new PgTeamService(pgTeamRepository);

            databaseUtil.createTableUsers("users");
            databaseUtil.createTableTeams("teams");
        }

        /**
         * поиск юзеров
         */
        /*if (userService != null) {
            List<User> find = userService.findAll();
            System.out.println(find);
        }

        if (teamService != null) {
            List<Team> find = teamService.findAll();
            System.out.println(find);
        }*/

        /**
         * поиск команды
         */
        /*if (userService != null) {
            Optional<User> userData = userService.findById(2L);
            System.out.println(userData);
        }

        if (teamService != null) {
            Optional<Team> teamData = teamService.findById(2L);
            System.out.println(teamData);
        }*/

        User user = User.builder()
            .name("Danil")
            .age(44)
            .salary(BigDecimal.valueOf(233333))
            .role(Role.FRONTEND_DEV)
            .team_id(0L)
            .build();

        User user2 = User.builder()
            .name("Oleg")
            .age(22)
            .salary(BigDecimal.valueOf(77000))
            .role(Role.BACKEND_DEV)
            .team_id(0L)
            .build();

        String description = user.getRole().getDescription();

        Team team = Team.builder()
            .name("Momo")
            .department("FrontDev")
            .build();

        Team team2 = Team.builder()
            .name("Chemp")
            .department("BackDev")
            .build();

        /**
         * сохранение юзеров
         */
        //System.out.println(userService.save(user));
        //System.out.println(userService.save(user2));

        /**
         * сохранение команды
         */
        //System.out.println(teamService.save(team));
        //System.out.println(teamService.save(team2));

        /**
         * удаление юзеров
         */
        //userService.deleteById(3L);

        /**
         * удаление команды
         */
        //teamService.deleteById(1L);

    }
}
