let updateGlobalActionIdStateByFunc = (state, func) => {
    let numbPart = Number(state.value.substring(9));
    numbPart = func(numbPart);
    state.value = 'actionId-' + numbPart;
}
export default updateGlobalActionIdStateByFunc