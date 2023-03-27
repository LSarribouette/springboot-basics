package fr.lsarribouette.springbootbasics.service;

import fr.lsarribouette.springbootbasics.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthService {
    public abstract List<Member> getAllMembers();

    public abstract Member getMemberById(long id);

    Optional<Member> toLogin(String email, String password);
}
