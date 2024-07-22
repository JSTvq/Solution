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

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String database = scanner.next();
        CrudService<User, Long> userService = null;
        CrudService<Team, Long> teamService = null;

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
        }

        /**
         * поиск юзеров
         */
        if (userService != null) {
            List<User> find = userService.findAll();
            System.out.println(find);
        }

        if (teamService != null) {
            List<Team> find = teamService.findAll();
            System.out.println(find);
        }

        /**
         * поиск команды
         */
        if (userService != null) {
            Optional<User> userData = userService.findById(2L);
            System.out.println(userData);
        }

        if (teamService != null) {
            Optional<Team> teamData = teamService.findById(2L);
            System.out.println(teamData);
        }

        User user = User.builder()
            .id(4L)
            .name("Danil")
            .age(44)
            .salary(233333)
            .role(Role.FRONTEND_DEV)
            .team_id(1)
            .build();

        Team team = Team.builder()
            .id(3L)
            .name("Momo")
            .department("BackDev")
            .build();

        /**
         * сохранение юзеров
         */
        //userService.save(user);

        /**
         * сохранение команды
         */
        //teamService.save(team);

        /**
         * удаление юзеров
         */
        //userService.deleteById(4L);

        /**
         * удаление команды
         */
        //teamService.deleteById(3L);

    }
}
