import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { addUser } from "../../../store/action/addUser";
import { Input, Button } from "../../InputField/InputField";
import { EmailFieldErrorMessage } from "./EmailFieldErrorMessage";

const SignUpForm = ({ setSuccessSignUp }) => {
  let dispatch = useDispatch();
  const apiToken = useSelector((state) => state.token);

  console.log(apiToken);

  const SignUpFunction = async (e) => {
    e.preventDefault();
    let data = Object.fromEntries(new FormData(e.target).entries());
    console.log(JSON.stringify(data));
    await fetch('/users',{
      method: 'POST',
      headers: {
        Authorization: apiToken,
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });
  };

  return (
    <section className="sign-up__form">
      <form id="sign-up-submit" onSubmit={SignUpFunction}>
        <Input
          field={{ _uid: "name", label: "Name" }}
          type="text"
          required="required"
        />
        <Input
          field={{ _uid: "email", label: "Email" }}
          type="email"
          required="required"
        />
        <Input
          field={{ _uid: "password", label: "Password" }}
          type="password"
          required="required"
          placeholder="Must be at least 6 characters"
        />
        <Input
          field={{
            _uid: "updates",
            label: "Sign up for email updates",
          }}
          type="checkbox"
          className="sign-up__chkbox-label"
        />
        <Button className="sign-up__button" type="submit" value="Sign Up" />
      </form>
    </section>
  );
};

export default SignUpForm;
