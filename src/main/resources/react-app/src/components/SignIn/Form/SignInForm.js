import { useSelector, useDispatch } from "react-redux";
import { isLoggedIn } from "../../../store/action/isLoggedIn";
import { Input, Button } from "../../InputField/InputField";
import { EmailFieldErrorMessage } from "./EmailFieldErrorMessage";

const SignInForm = () => {

  const dispatch = useDispatch();
  const apiToken = useSelector((state) => state.token);
  const onSubmit = async (e) => {
    e.preventDefault();

    let data = Object.fromEntries(new FormData(e.target).entries());

    await fetch(`/users/search?email=${data.email}&password=${data.password}`, {
      method: "GET",
      headers: new Headers({
        Authorization: apiToken,
        Accept: "application/json",
        "Content-Type": "application/json",
      }),
    })
      .then((res) => {
        if (res.ok) dispatch(isLoggedIn(res.json()));
        else {
          EmailFieldErrorMessage(e, `This email address doesn't exist.`);
          throw new Error(res.status);
        }
      })
      .catch((error) => console.log(error));
  };

  return (
    <section className="sign-up__form" onSubmit={onSubmit}>
      <form id="login-submit">
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
        <Button className="sign-up__button" type="submit" value="Sign In" />
      </form>
    </section>
  );
};

export default SignInForm;
