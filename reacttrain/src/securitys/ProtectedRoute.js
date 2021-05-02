// import React from 'react';
// import { Route } from 'react-router-dom';

// const ProtectedRoute = ({ component: Component, ...rest }) => {
//   return (
//     <Route {...rest} render={
//       props => <Component {...rest} {...props} />
//     } />
//   )
// }

// export default ProtectedRoute;

import React from "react";
import { Redirect, Route } from "react-router-dom";

function ProtectedRoute({ component: Component, ...rest }) {
  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  return (
    <Route
      {...rest}
      render={(props) => {
        if (token !== null && role === "ADMIN") {
          return <Component />;
        } else {
          return (
            <Redirect to={{ pathname: "", state: { from: props.location } }} />
          );
        }
      }}
    />
  );
}

export default ProtectedRoute;