package com.seanpx.controller;

import com.seanpx.domain.User;
import com.seanpx.utils.JsonData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/prv/order")
public class VideoOrderController2 {

    @RequestMapping("place2")
    public JsonData saveOrder(HttpServletRequest request) {

        // Retrieve the user object placed by the filter
        User user = (User) request.getAttribute("loginUser");

        if (user == null) {
            // If somehow it's null, respond accordingly
            return JsonData.buildError("Not authenticated. No user found.");
        }

        // Now you have user.getId() and other user fields
        int userId = user.getId();

        // Return a JSON response with the user ID included
        // Example: return just a success message along with the userId
        return JsonData.buildSuccess(
                String.format("Order Placed Successfully by userId=%d", userId)
        );
    }
}
