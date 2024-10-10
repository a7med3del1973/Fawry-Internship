# JakartaEE & Web Servlet

## Resources:

- ### Eng.Hany Ahmed [Sessions](https://drive.google.com/file/d/1bS1_Qj2d3s4ugsetuxif0ybwn3S_GNT5/view?usp=drive_link) & [Slides](https://drive.google.com/file/d/1eV9cA6QnpnPP3RExEafQH0_QTLe_uq9j/view?usp=drive_link)

## Task:

Create web application using servlets

- Servlet for login that creats a session (path: `/login`) - valid users may be store in memory
- Servlet for adding products (path: `catalog/products` method: `POST`) and listing all products (path: `catalog/products` method: `GET`)
- Servlet for listing products created by the logged-in user (path: `catalog/my-products` method: `GET`)
- Servlet for displying statisitics like number of products, total price of all products (path: `catalog/stats` method: `GET`)
- you may save produts in memory using List, Set or Map, but it should be shared a cross all users
- Filter to protect all paths starting with `catalog` preventing non logged-in users from accessing them
