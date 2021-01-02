package org.balaji.multiplex.application.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Assert;
import org.junit.Test;

public class UsersControllerTest {

    @Test
    public void fetch() {
        try {
            HttpResponse<String> response = Unirest.get("http://localhost:8080/users/5f94343900aa835797e971fe")
                    .header("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJub25jZSI6IlZueWVsS093eDl0VGVad0syV0UyUWM1azVwUVc5S01JZ1pOVWNPa3drdU0iLCJhbGciOiJSUzI1NiIsIng1dCI6IkhsQzBSMTJza3hOWjFXUXdtak9GXzZ0X3RERSIsImtpZCI6IkhsQzBSMTJza3hOWjFXUXdtak9GXzZ0X3RERSJ9.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC80YWUxYjE2Ny01NjJjLTRjYTMtYTQwMS1jNjhhODdiMjMzODUvIiwiaWF0IjoxNTgyMDQwNDY4LCJuYmYiOjE1ODIwNDA0NjgsImV4cCI6MTU4MjA0NDM2OCwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IjQyTmdZQWd2NnBQYlltcDB4MEFxL3RRVzMrMTFIclp6ZXIvV1Q5TGV2R2VQVUwvaTR0a0EiLCJhbXIiOlsicHdkIl0sImFwcF9kaXNwbGF5bmFtZSI6IlRlc3RMZVhXb3JrUGxhY2UiLCJhcHBpZCI6ImU3YmUxNGQ4LTY0NjctNGExNS1hMjk1LTVjYTFiYjMwZGUyNyIsImFwcGlkYWNyIjoiMCIsImZhbWlseV9uYW1lIjoiSHV5bmgiLCJnaXZlbl9uYW1lIjoiUGhpZW0iLCJpcGFkZHIiOiIyNy41LjI5LjE0IiwibmFtZSI6IlBoaWVtIEh1eW5oIiwib2lkIjoiMDZjZmFjYWQtZjdhMS00NDI5LTk3NDktOTczNWIzMDQ0ZTZhIiwicGxhdGYiOiIxNCIsInB1aWQiOiIxMDAzMjAwMDkxQkUzNTg4Iiwic2NwIjoiRGlyZWN0b3J5LlJlYWQuQWxsIEZpbGVzLlJlYWQuQWxsIEZpbGVzLlJlYWRXcml0ZS5BbGwgU2l0ZXMuUmVhZC5BbGwgU2l0ZXMuUmVhZFdyaXRlLkFsbCBVc2VyLlJlYWQgcHJvZmlsZSBvcGVuaWQgZW1haWwiLCJzdWIiOiJQNlgzZE53UEFkc3owRzRFVXN4bUxOdUlJcTY1OWp0Nl9LY1duVDZ0OG80IiwidGlkIjoiNGFlMWIxNjctNTYyYy00Y2EzLWE0MDEtYzY4YTg3YjIzMzg1IiwidW5pcXVlX25hbWUiOiJQaGllbS5IdXluaEBnc3dvcmtwbGFjZXRlc3Qub25taWNyb3NvZnQuY29tIiwidXBuIjoiUGhpZW0uSHV5bmhAZ3N3b3JrcGxhY2V0ZXN0Lm9ubWljcm9zb2Z0LmNvbSIsInV0aSI6IkltV2oxYXktNEVPMWpmSzRwZ3B3QUEiLCJ2ZXIiOiIxLjAiLCJ3aWRzIjpbImYyOGExZjUwLWY2ZTctNDU3MS04MThiLTZhMTJmMmFmNmI2YyIsIjYyZTkwMzk0LTY5ZjUtNDIzNy05MTkwLTAxMjE3NzE0NWUxMCIsImZlOTMwYmU3LTVlNjItNDdkYi05MWFmLTk4YzNhNDlhMzhiMSIsIjI5MjMyY2RmLTkzMjMtNDJmZC1hZGUyLTFkMDk3YWYzZTRkZSIsIjY5MDkxMjQ2LTIwZTgtNGE1Ni1hYTRkLTA2NjA3NWIyYTdhOCIsImYyZWY5OTJjLTNhZmItNDZiOS1iN2NmLWExMjZlZTc0YzQ1MSIsImYwMjNmZDgxLWE2MzctNGI1Ni05NWZkLTc5MWFjMDIyNjAzMyIsIjcyOTgyN2UzLTljMTQtNDlmNy1iYjFiLTk2MDhmMTU2YmJiOCJdLCJ4bXNfc3QiOnsic3ViIjoiN2VMRTZkc1pfTnZvb2dxZE0yOGoxS3pxYlNMNVN0TVBqd20yUV90eGZiUSJ9LCJ4bXNfdGNkdCI6MTU3NjAxMDU3NH0.EiYXvXsZcZdMBuu5rpEP4xbiLiKH8zRj1bJnBg_swyebuB83PaRJeSaqxQgGx4FHnXIisy5kPeuyIPD-cYSMQrkiL_y-Pay5LmYX1wj-dvQ_X2prqP4OVkarLWzhiBz8N2_Wrcbyld1YTp1VsaZgYacMDQBkOS_IrlJwcfm-ROx1t5rV_mxU-tpg0r8ufjokVWhNvFIyWNkDRAv_1bNQAEqtliEQwhn4cTW5ov3B8ZdffNW7T7ilsS38RGllSV3eExNHwXEI5lJjTrvyg7KdGuvHAKVOhItVq56hOiwpUm6tmAuGFfvQ4k8FAGrSHKQ_c_5jrRQ-FslJhCd3eKdb5Q")
                    .header("cache-control", "no-cache")
                    .asString();

            Assert.assertNotNull(response.getBody());
            Assert.assertEquals(response.getStatus(), 200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create() {
        try {
            HttpResponse<String> response = Unirest.post("http://localhost:8080/users")
                    .header("Content-Type", "application/json")
                    .body("{\r\n  \"email\": \"test.user1@balajimultiplex.com\",\r\n  \"firstName\": \"Robert\",\r\n  \"isActive\": true,\r\n  \"isDeleted\": false,\r\n  \"lastName\": \"Vadra\",\r\n  \"password\": \"Password@123\",\r\n  \"roles\": [\r\n    \"ROLE_USER_ADMIN\"\r\n  ],\r\n  \"username\": \"test_user1\"\r\n}\r\n")
                    .asString();

            Assert.assertEquals(response.getStatus(),200);
        }catch (Exception e){}

    }

    @Test
    public void update() {
        try {
            HttpResponse<String> response = Unirest.post("http://localhost:8080/users/5f944d2b6374402485acae68")
                    .header("Content-Type", "application/json")
                    .body("{\r\n  \"email\": \"test.user1@balajimultiplex.com\",\r\n  \"firstName\": \"Robert2\",\r\n  \"isActive\": true,\r\n  \"isDeleted\": false,\r\n  \"lastName\": \"Vadra\",\r\n  \"password\": \"Password@123\",\r\n  \"roles\": [\r\n    \"ROLE_USER_ADMIN\"\r\n  ],\r\n  \"username\": \"test_user1\"\r\n}\r\n")
                    .asString();

            Assert.assertEquals(response.getStatus(),200);

        }catch (Exception e){

        }
    }

    @Test
    public void list() {
        try {
            HttpResponse<String> response = Unirest.get("http://localhost:8080/users")
                    .header("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJub25jZSI6IlZueWVsS093eDl0VGVad0syV0UyUWM1azVwUVc5S01JZ1pOVWNPa3drdU0iLCJhbGciOiJSUzI1NiIsIng1dCI6IkhsQzBSMTJza3hOWjFXUXdtak9GXzZ0X3RERSIsImtpZCI6IkhsQzBSMTJza3hOWjFXUXdtak9GXzZ0X3RERSJ9.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC80YWUxYjE2Ny01NjJjLTRjYTMtYTQwMS1jNjhhODdiMjMzODUvIiwiaWF0IjoxNTgyMDQwNDY4LCJuYmYiOjE1ODIwNDA0NjgsImV4cCI6MTU4MjA0NDM2OCwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IjQyTmdZQWd2NnBQYlltcDB4MEFxL3RRVzMrMTFIclp6ZXIvV1Q5TGV2R2VQVUwvaTR0a0EiLCJhbXIiOlsicHdkIl0sImFwcF9kaXNwbGF5bmFtZSI6IlRlc3RMZVhXb3JrUGxhY2UiLCJhcHBpZCI6ImU3YmUxNGQ4LTY0NjctNGExNS1hMjk1LTVjYTFiYjMwZGUyNyIsImFwcGlkYWNyIjoiMCIsImZhbWlseV9uYW1lIjoiSHV5bmgiLCJnaXZlbl9uYW1lIjoiUGhpZW0iLCJpcGFkZHIiOiIyNy41LjI5LjE0IiwibmFtZSI6IlBoaWVtIEh1eW5oIiwib2lkIjoiMDZjZmFjYWQtZjdhMS00NDI5LTk3NDktOTczNWIzMDQ0ZTZhIiwicGxhdGYiOiIxNCIsInB1aWQiOiIxMDAzMjAwMDkxQkUzNTg4Iiwic2NwIjoiRGlyZWN0b3J5LlJlYWQuQWxsIEZpbGVzLlJlYWQuQWxsIEZpbGVzLlJlYWRXcml0ZS5BbGwgU2l0ZXMuUmVhZC5BbGwgU2l0ZXMuUmVhZFdyaXRlLkFsbCBVc2VyLlJlYWQgcHJvZmlsZSBvcGVuaWQgZW1haWwiLCJzdWIiOiJQNlgzZE53UEFkc3owRzRFVXN4bUxOdUlJcTY1OWp0Nl9LY1duVDZ0OG80IiwidGlkIjoiNGFlMWIxNjctNTYyYy00Y2EzLWE0MDEtYzY4YTg3YjIzMzg1IiwidW5pcXVlX25hbWUiOiJQaGllbS5IdXluaEBnc3dvcmtwbGFjZXRlc3Qub25taWNyb3NvZnQuY29tIiwidXBuIjoiUGhpZW0uSHV5bmhAZ3N3b3JrcGxhY2V0ZXN0Lm9ubWljcm9zb2Z0LmNvbSIsInV0aSI6IkltV2oxYXktNEVPMWpmSzRwZ3B3QUEiLCJ2ZXIiOiIxLjAiLCJ3aWRzIjpbImYyOGExZjUwLWY2ZTctNDU3MS04MThiLTZhMTJmMmFmNmI2YyIsIjYyZTkwMzk0LTY5ZjUtNDIzNy05MTkwLTAxMjE3NzE0NWUxMCIsImZlOTMwYmU3LTVlNjItNDdkYi05MWFmLTk4YzNhNDlhMzhiMSIsIjI5MjMyY2RmLTkzMjMtNDJmZC1hZGUyLTFkMDk3YWYzZTRkZSIsIjY5MDkxMjQ2LTIwZTgtNGE1Ni1hYTRkLTA2NjA3NWIyYTdhOCIsImYyZWY5OTJjLTNhZmItNDZiOS1iN2NmLWExMjZlZTc0YzQ1MSIsImYwMjNmZDgxLWE2MzctNGI1Ni05NWZkLTc5MWFjMDIyNjAzMyIsIjcyOTgyN2UzLTljMTQtNDlmNy1iYjFiLTk2MDhmMTU2YmJiOCJdLCJ4bXNfc3QiOnsic3ViIjoiN2VMRTZkc1pfTnZvb2dxZE0yOGoxS3pxYlNMNVN0TVBqd20yUV90eGZiUSJ9LCJ4bXNfdGNkdCI6MTU3NjAxMDU3NH0.EiYXvXsZcZdMBuu5rpEP4xbiLiKH8zRj1bJnBg_swyebuB83PaRJeSaqxQgGx4FHnXIisy5kPeuyIPD-cYSMQrkiL_y-Pay5LmYX1wj-dvQ_X2prqP4OVkarLWzhiBz8N2_Wrcbyld1YTp1VsaZgYacMDQBkOS_IrlJwcfm-ROx1t5rV_mxU-tpg0r8ufjokVWhNvFIyWNkDRAv_1bNQAEqtliEQwhn4cTW5ov3B8ZdffNW7T7ilsS38RGllSV3eExNHwXEI5lJjTrvyg7KdGuvHAKVOhItVq56hOiwpUm6tmAuGFfvQ4k8FAGrSHKQ_c_5jrRQ-FslJhCd3eKdb5Q")
                    .header("cache-control", "no-cache")
                    .asString();

            Assert.assertNotNull(response.getBody());
            Assert.assertEquals(response.getStatus(), 200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}